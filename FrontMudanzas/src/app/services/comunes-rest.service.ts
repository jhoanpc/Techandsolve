import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';
import {Observable} from "rxjs";
import {IDuke} from './Duke';
import {IViajes} from './Viajes';
import {InformacionMudanzaDTO} from './InformacionMudanzaDTO';
import { HttpHeaders } from '@angular/common/http';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
@Injectable({
  providedIn: 'root'
})

export class ComunesRestService {
  public URL_BASE  = null;
 
  
  constructor (private http: HttpClient){
    var host = window.location.hostname;
    var portQA = window.location.port ? ":" + window.location.port : "";
    var portQD = ":8090"; // puerto para pruebas
     this.URL_BASE = "http://"+host +portQD+"/apiRestWeb/rest";
  }
   
  
     
   public guardarRegistro(informacionMudanzaDTO :InformacionMudanzaDTO){

    let formData:FormData = new FormData();
        //formData.append('uploadfile', informacionMudanzaDTO.documento, informacionMudanzaDTO.numeroDocumento,informacionMudanzaDTO.tipoDocumento );
        //formData.append('numero', informacionMudanzaDTO.numeroDocumento.toString());
        //formData.append('tipoDocumento', informacionMudanzaDTO.tipoDocumento.toString());
        let headers = new Headers();
        /** In Angular 5, including the header Content-Type can invalidate your request */
        headers.append('Content-Type', 'multipart/form-data');
        headers.append('Accept', 'application/json');


    
        
  
    //this.http.post(this.URL_BASE + "/mudanzas/guardarRegistro1",formData);
    return this.http.post(this.URL_BASE + "/mudanzas/guardarRegistro", 
    JSON.stringify(informacionMudanzaDTO), httpOptions);
 // const req = new HttpRequest('POST', this.URL_BASE + "/mudanzas/guardarRegistro1", formData, {
   // reportProgress: true
 // });

 // this.http.request(req).subscribe(event => {

  //});


   }

}
