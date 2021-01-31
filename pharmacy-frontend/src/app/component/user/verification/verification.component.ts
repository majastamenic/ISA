import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/service/user.service';
import { User } from '../model/user-model';

@Component({
  selector: 'app-verification',
  templateUrl: './verification.component.html',
  styleUrls: ['./verification.component.css']
})
export class VerificationComponent implements OnInit {

  verificationCode: string =  '';

  constructor(private userService: UserService) { }

  ngOnInit(): void {
  }

  verification(): void {
    this.userService.verification(this.verificationCode).subscribe((returnedUser: User) => {
      alert('User with email ' + returnedUser.email + ' is registered.');
    },
      (err: any) => {
        alert('Error while verification ' + err.error.message);
      });
  }
}
