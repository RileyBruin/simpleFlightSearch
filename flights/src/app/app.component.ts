import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { DataService } from 'src/app/data.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'flights';
  allflights:Object;
  hasResult:boolean= true;
  messageForm: FormGroup;
  operate:boolean=true;
  errorMessage:Array<String>;
  hasplace:boolean=true;


  constructor(
    private formBuilder: FormBuilder, 
    private dataService: DataService, 
    private router: Router
    ) { 
    this.messageForm = this.formBuilder.group({
      flight_num:[''],
      origin:[''],
      destination:[''],
      date:['']
    })
  }

  onSubmit(){

    this.errorMessage=[];
    this.operate=true;

    console.log(this.messageForm.value.date);
    

    this.messageForm.value.origin = this.messageForm.value.origin.toUpperCase();
    this.messageForm.value.destination = this.messageForm.value.destination.toUpperCase();
    
    if(this.messageForm.value.date==""){
      this.operate=false;
      this.allflights = [];
      this.errorMessage.push("Please choose your departure date");
    }

    if(this.operate){
      if(this.messageForm.value.origin!="" || this.messageForm.value.destination!=""){
        this.hasplace=true;
        if(this.messageForm.value.origin=="" || this.messageForm.value.destination==""){
          this.operate=false;
          this.allflights = [];
          this.errorMessage.push("Please input both origin and destination");
        }}else{
          this.hasplace=false;
        }
      }

    if(this.operate){
      if(!this.hasplace &&!this.messageForm.value.flight_num){
        this.operate=false;
        this.allflights = [];
        this.errorMessage.push("Please input a flight number or choose both origin and destination ");
      }
    }

    if(this.operate){
      this.dataService.searchflight(this.messageForm.value).subscribe(data=>{
        this.allflights = data;
          if(data[0]==null){
            this.hasResult=false;
          }else{
            this.hasResult=true;
          }
          // console.log('Sent');
        })
    }
    
  }


}
