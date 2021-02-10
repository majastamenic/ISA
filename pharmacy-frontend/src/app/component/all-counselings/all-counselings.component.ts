import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CounselingsService } from 'src/app/service/counselings.service';
import { Counseling } from '../../model/counseling';

@Component({
  selector: 'app-all-counselings',
  templateUrl: './all-counselings.component.html',
  styleUrls: ['./all-counselings.component.css']
})
export class AllCounselingsComponent implements OnInit {

  email: string;
  counselings: Counseling[] = [];
  counseling: any;

  constructor(private allCounseling: CounselingsService, private router: Router) {
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
