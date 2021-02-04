import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AllCounselingsService } from 'src/app/service/all-counselings.service';
import { Counseling } from '../user/model/counseling';

@Component({
  selector: 'app-all-counselings',
  templateUrl: './all-counselings.component.html',
  styleUrls: ['./all-counselings.component.css']
})
export class AllCounselingsComponent implements OnInit {

  email: string;
  counselings: Counseling[] = [];

  constructor(private allCounseling: AllCounselingsService, private router: Router) {
    this.email = '';
   }


  ngOnInit(): void {
    let loggedUser = sessionStorage.getItem("user");
    
    if(loggedUser){
      this.allCounseling.getCounseltings(loggedUser).subscribe((data: Counseling[]) => {
        this.counselings = data;
        console.log(this.counselings)
      });
    }
  }

}
