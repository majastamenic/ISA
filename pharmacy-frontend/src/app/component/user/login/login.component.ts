import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  private user: User;

  constructor(private httpClient: HttpClient) { }

  ngOnInit(): void {
  }

  login(): void {
    this.httpClient.post(this.user, )
  }
}
