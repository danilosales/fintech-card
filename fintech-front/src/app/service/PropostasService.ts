import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse, HttpClientModule, HttpParams } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { Proposta } from '../model/Proposta';
import { environment } from 'src/environments/environment.prod';

const url = 'http://localhost:8080/api/propostas';
const httpOptions = {
    headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Access-Control-Allow-Origin': '*'
    })
};

@Injectable()
export class PropostasService {
    data: Observable<Proposta>;
    constructor(private http: HttpClient) { }

    private extractData(res: Response) {
        const body = res;
        return body || {};
    }

    inserirProposta(proposta: Proposta): Observable<Proposta> {
        console.log(proposta);

        this.data = this.http.post<Proposta>(url, proposta);

        return this.data;
    }

    buscarPropostaPorCpf(cpf: string): Observable<Proposta> {
        console.log(cpf);

        const headerGet = {
            headers: new HttpHeaders({
                'Content-Type': 'application/json',
                'Access-Control-Allow-Origin': 'http://localhost:3000',
                'Access-Control-Allow-Methods': 'GET, PUT, POST, DELETE, HEAD, OPTIONS'
            })
        };

        const endPoint = url + '/cliente/' + cpf;

        return this.http.get<Proposta>(endPoint, headerGet);
    }
}
