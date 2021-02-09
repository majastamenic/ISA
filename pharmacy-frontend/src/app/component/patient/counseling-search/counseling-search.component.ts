import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-counseling-search',
  templateUrl: './counseling-search.component.html',
  styleUrls: ['./counseling-search.component.css']
})
export class CounselingSearchComponent implements OnInit {

  loggedUser = sessionStorage.getItem('user');
  isCounselingFound: boolean = false;

  startTime = {hour: 13, minute: 30};
  eagerDate: any;
  minuteStep: number = 15;

  pharmacies: any;

  constructor(private router: Router,
              private toastrService: ToastrService,
              ) { }

  ngOnInit(): void {
    if(this.loggedUser){

    }else{
      this.router.navigate(['login']);
      this.toastrService.info('Please log in first.');
    }
  }

  find(){
    let DateTime = {
      date: `${this.eagerDate.year}-${this.eagerDate.mounth}-${this.eagerDate.day}`,
      time: `${this.startTime.hour}-${this.startTime.minute}`
    }
  }
}
