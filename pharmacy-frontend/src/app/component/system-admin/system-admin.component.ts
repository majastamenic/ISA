import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { UserService } from 'service/user.service';

@Component({
  selector: 'app-system-admin',
  templateUrl: './system-admin.component.html',
  styleUrls: ['./system-admin.component.css']
})
export class SystemAdminComponent implements OnInit {

  constructor(private userService: UserService, private router: Router,
    private toastrService: ToastrService) { }

  ngOnInit(): void {
    if(!this.userService.isAdmin()){
      this.router.navigate(['home']);
      this.toastrService.error('Unauthorized access.');
    }
  }

}
