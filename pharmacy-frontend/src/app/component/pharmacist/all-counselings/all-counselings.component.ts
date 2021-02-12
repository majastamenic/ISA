import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CounselingsService } from 'src/app/service/counselings.service';
import { Counseling } from '../../../model/counseling';

@Component({
  selector: 'app-all-counselings',
  templateUrl: './all-counselings.component.html',
  styleUrls: ['./all-counselings.component.css']
})
export class AllCounselingsComponent implements OnInit {

  counseling: Counseling[] = [];
  loggedUser: any = sessionStorage.getItem('user');
  loggedUserRole: any = sessionStorage.getItem('role');

  constructor(private allCounseling: CounselingsService, private router: Router) {
   }

  ngOnInit(): void {    
    if(this.loggedUser && this.loggedUserRole == 'PHARMACIST'){
      this.allCounseling.getCounseltings(this.loggedUser).subscribe((data: Counseling[]) => {
        this.counseling = data;
        console.log(this.counseling)
      });
    }
  }

}
