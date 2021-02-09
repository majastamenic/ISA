import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { CounselingsService } from 'service/counselings.service';

@Component({
  selector: 'app-counselings',
  templateUrl: './counselings.component.html',
  styleUrls: ['./counselings.component.css']
})
export class CounselingsComponent implements OnInit {

  loggedUser = sessionStorage.getItem('user');
  counselings: any = [];
  
  constructor(private counselingService: CounselingsService,
              private toastrService: ToastrService,
              private router: Router) { }

  ngOnInit(): void {
    if(this.loggedUser){
      this.counselingService.getPatientCounselings(this.loggedUser).subscribe(data => {
        this.counselings = data;
      }, error => {
        this.toastrService.error("An error has occured while retriveing counselings.");
      });
    }else{
      this.router.navigate(['login']);
      this.toastrService.info('Pleaste log in first.');
    }
  }

}
