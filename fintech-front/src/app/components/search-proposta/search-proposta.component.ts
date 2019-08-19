import { Component, OnInit } from '@angular/core';
import { Proposta } from '../../model/Proposta';
import { PropostasService } from '../../service/PropostasService';
import { Validators, FormBuilder, FormGroup, FormControl} from '@angular/forms';

@Component({
  selector: 'app-search-proposta',
  templateUrl: './search-proposta.component.html'
})
export class SearchPropostaComponent implements OnInit {

  propostaRetornada: Proposta = new Proposta();
  propostaForm: FormGroup;
  display: boolean = false;

  constructor(
    private propostaService: PropostasService,
    private fb: FormBuilder
  ) { }

  ngOnInit() {
    this.propostaForm = this.fb.group({
      cpf: new FormControl('', Validators.required)
    });
  }

  onSubmitForm() {
    const cpf = this.propostaForm.get('cpf').value.replace(/\D/g, '');

    this.propostaService.buscarPropostaPorCpf(cpf).subscribe(
      data => {
        if(!data) {
          this.display = true;
        } else {
          this.display = false;
        }
        this.propostaRetornada = data;
      },
      error => {
        this.display = true;
        this.propostaRetornada = null;
      }
    );

  }

}


