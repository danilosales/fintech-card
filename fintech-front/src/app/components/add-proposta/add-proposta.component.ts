import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Proposta } from '../../model/Proposta';
import { PropostasService } from '../../service/PropostasService';
import { Validators, FormBuilder, FormGroup, FormControl } from '@angular/forms';
import { SelectItem } from 'primeng/components/common/selectitem';

@Component({
  selector: 'app-add-proposta',
  templateUrl: './add-proposta.component.html',
})
export class AddPropostaComponent implements OnInit {

  proposta: Proposta = new Proposta();
  propostaForm: FormGroup;
  sexoTipos: SelectItem[];
  estadoCivilTipos: SelectItem[];
  estadosTipos: SelectItem[];
  display: boolean = false;
  displayMotivo: boolean = false;

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private propostaService: PropostasService,
    private formBuilder: FormBuilder
  ) { }

  ngOnInit() {
    this.iniciarFormulario();
    this.carregarCombos();
  }

  iniciarFormulario(): void {
    this.propostaForm = this.formBuilder.group({
      nome: new FormControl('', Validators.required),
      cpf: new FormControl('', Validators.required),
      idade: new FormControl('', Validators.required),
      sexo: new FormControl('', Validators.required),
      estado: new FormControl('', Validators.required),
      estadoCivil: new FormControl('', Validators.required),
      dependentes: new FormControl('', Validators.required),
      renda: new FormControl('', Validators.required),
      statusAnalise: new FormControl(''),
      limiteSugerido: new FormControl(''),
      motivoReprovacao: new FormControl('')
    });
}

carregarCombos(): void {
  this.sexoTipos = [
    { label: 'Selecione um Sexo', value: '' },
    { label: 'Masculino', value: 'M' },
    { label: 'Feminino', value: 'F' }
  ];

  this.estadoCivilTipos = [
    { label: 'Selecione o Estado Civil', value: '' },
    { label: 'Casado(a)', value: 'casado' },
    { label: 'Solteiro(a)', value: 'solteiro' },
    { label: 'Viúvo(a)', value: 'viuva' },
    { label: 'Divorciado(a)', value: 'divorciado' }
  ];

  this.estadosTipos = [
    { label: 'Selecione o Estado', value: '' },
    { label: 'AC', value: 'AC' },
    { label: 'AL', value: 'AL' },
    { label: 'AM', value: 'AM' },
    { label: 'AP', value: 'AP' },
    { label: 'BA', value: 'BA' },
    { label: 'CE', value: 'CE' },
    { label: 'DF', value: 'DF' },
    { label: 'ES', value: 'ES' },
    { label: 'GO', value: 'GO' },
    { label: 'MA', value: 'MA' },
    { label: 'MG', value: 'MG' },
    { label: 'MS', value: 'MS' },
    { label: 'MT', value: 'MT' },
    { label: 'PA', value: 'PA' },
    { label: 'PB', value: 'PB' },
    { label: 'PE', value: 'PE' },
    { label: 'PI', value: 'PI' },
    { label: 'PR', value: 'PR' },
    { label: 'RJ', value: 'RJ' },
    { label: 'RN', value: 'RN' },
    { label: 'RO', value: 'RO' },
    { label: 'RR', value: 'RR' },
    { label: 'RS', value: 'RS' },
    { label: 'SC', value: 'SC' },
    { label: 'SE', value: 'SE' },
    { label: 'SP', value: 'SP' },
    { label: 'TO', value: 'TO' }
  ];
}

onSubmitForm(value: string): void {
    const proposta = new Proposta();

    proposta.cpf = this.propostaForm.get('cpf').value;
    proposta.nome = this.propostaForm.get('nome').value;
    proposta.idade = this.propostaForm.get('idade').value;
    proposta.sexo = this.propostaForm.get('sexo').value;
    proposta.estadoCivil = this.propostaForm.get('estadoCivil').value;
    proposta.qtdDependentes = this.propostaForm.get('dependentes').value;
    proposta.renda = this.propostaForm.get('renda').value;
    proposta.siglaEstado = this.propostaForm.get('estado').value;

    this.propostaService.inserirProposta(proposta).subscribe(
        res => {
            this.proposta = res;
            this.display = true;
            if(this.proposta.status === 'Reprovado') {
              this.displayMotivo = true;
            }
        }, error => {
            this.proposta = null;
        });
  }
}
