import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-all-counselings',
  templateUrl: './all-counselings.component.html',
  styleUrls: ['./all-counselings.component.css']
})
export class AllCounselingsComponent implements OnInit {

  email: string;

  constructor(private router: Router) {
    this.email = '';
   }

  ngOnInit(): void {
  }

}
// [(ngmodel)]=.. - bind
