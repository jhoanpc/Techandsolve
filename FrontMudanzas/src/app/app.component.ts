




import { Component, OnInit, OnDestroy, ViewChild } from '@angular/core';
import { HttpClient, HttpHeaders, HttpEventType, HttpRequest, HttpErrorResponse, HttpEvent } from '@angular/common/http';
import { FormControl, FormGroup, Validators, NgForm } from '@angular/forms';

import {IViajes} from './services/Viajes';
import {IDuke} from './services/Duke'
import { ComunesRestService } from './services/comunes-rest.service';
import {Observable} from "rxjs";
import { map, filter, switchMap } from 'rxjs/operators';
import {InformacionMudanzaDTO} from './services/InformacionMudanzaDTO';
import {RequestOptions, Request, RequestMethod} from '@angular/http';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers:[ComunesRestService]

})
export class AppComponent implements OnInit, OnDestroy {
  title = 'Mi compañia de mudanzas';
  dukes = [{name:"jan", age:1}, {name:"jan rober", age:2}];
  iviajes :IViajes[];
  

  informacionMudanza = new InformacionMudanzaDTO();
  
  
  

  statusCreateForm: FormGroup;
  fileDescription: FormControl;
  fileToUpload: File  = null;
  uploadProgress:number = 0;
  uploadComplete:boolean = false;
  uploadingProgressing:boolean = false;
  fileUploadSub: any;
  serverResponse: any;

  @ViewChild('myInput')
  myFileInput: any;

  constructor ( private comunesRestService:ComunesRestService){

  }

  

  ngOnInit(){
   

     this.fileDescription  = new FormControl("", [
      Validators.required,
      Validators.minLength(4),
      Validators.maxLength(280)
      ]);
      this.statusCreateForm = new FormGroup({
        'description': this.fileDescription,
      });
   
  }


  ngOnDestroy (){
    if (this.fileUploadSub){
        this.fileUploadSub.unsubscribe()
    }
     }

   

  
  fileChange(event) {
    let fileList: FileList = event.target.files;
    if(fileList.length > 0) {
        let file = fileList[0];
        let formData:FormData = new FormData();
        formData.append('uploadFile', file, file.name);
        let headers = new Headers();
        /** In Angular 5, including the header Content-Type can invalidate your request */
        headers.append('Content-Type', 'multipart/form-data');
        headers.append('Accept', 'application/json');
       // let options = new RequestOptions({ headers: headers });
       // this.http.post(`${this.apiEndPoint}`, formData, options)
        //    .map(res => res.json())
        //    .catch(error => Observable.throw(error))
         //   .subscribe(
          //      data => console.log('success'),
            //    error => console.log(error)
            //)
    }
  }


  handleProgress(event){
    if (event.type === HttpEventType.DownloadProgress) {
        this.uploadingProgressing =true
        this.uploadProgress = Math.round(100 * event.loaded / event.total)
      }

      if (event.type === HttpEventType.UploadProgress) {
        this.uploadingProgressing =true
        this.uploadProgress = Math.round(100 * event.loaded / event.total)
      }

      if (event.type === HttpEventType.Response) {
        // console.log(event.body);
        this.uploadComplete = true
        this.serverResponse = event.body
      }
    }
    handleSubmit(event:any){
      event.preventDefault();
      
       
       this.informacionMudanza.tipoDocumento="CC";
      this.comunesRestService.guardarRegistro(this.informacionMudanza);
      
  }

  guardarRegistro(){
    this.informacionMudanza.tipoDocumento="CC";
    this.comunesRestService.guardarRegistro(this.informacionMudanza);
  }


    handleFileInput(files: FileList) {
        let file = files.item(0);
        console.log("file input has changed. The file is", file)
        this.fileToUpload = file
        this.informacionMudanza.documento = file;
    }

    resetFileInput() {
        console.log(this.myFileInput.nativeElement.files);
        this.myFileInput.nativeElement.value = "";
        console.log(this.myFileInput.nativeElement.files);
    }
}
