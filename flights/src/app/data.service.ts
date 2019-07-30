import { Injectable } from '@angular/core';
import { HttpClient ,HttpHeaders, HttpResponse, HttpParams} from '@angular/common/http'; 
import { Observable, Subject } from 'rxjs';

@Injectable({
    providedIn: 'root'
  })
export class DataService{

    constructor(
        private http: HttpClient,
        ) { }


    searchflight(data: any){
        const options = { headers: new HttpHeaders({'Content-Type': 'application/json'}) };  
        return this.http.post('//localhost:8080/flight',data, options)
        }


}