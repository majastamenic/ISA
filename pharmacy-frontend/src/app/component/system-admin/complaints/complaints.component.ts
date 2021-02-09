import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { ComplaintService } from 'src/app/service/complaint.service';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-complaints',
  templateUrl: './complaints.component.html',
  styleUrls: ['./complaints.component.css']
})
export class ComplaintsComponent implements OnInit {

  complaints: any;
  showAddResponse: boolean = false;
  enableEditIndex = null;
  prevResponse = '';

  constructor(private complaintService: ComplaintService, private toastrService: ToastrService,
    private router: Router, private userService: UserService) { }

  ngOnInit(): void {
    if(!this.userService.isAdmin()){
      this.router.navigate(['home']);
      this.toastrService.error('Unauthorized access.');
    }
    this.complaintService.getAll().subscribe((listComplaints: any) => {
      this.complaints = listComplaints;
    },
    (err: any) => {
      this.toastrService.error('Error ' + err.error.message);
    });
  }

  addResponse(e:Event, i: any){
    this.prevResponse = this.complaints[i].response;
    this.showAddResponse = true;
    this.enableEditIndex = i;
  }

  sendResponse(i: any){
    this.complaintService.addResponse(this.complaints[i]).subscribe((response: any) => {
      this.showAddResponse = false;
      this.toastrService.success('Changed complaint.')
    },
    (err: any) => {
      this.toastrService.error('Error ' + err.error.message);
    });
  }

  delete(i: any){
    this.complaintService.delete(this.complaints[i].id).subscribe((response: any) => {
      this.toastrService.success("Complaints deleted.")
      location.reload();
    },
    (err: any) => {
      this.toastrService.error('Error ' + err.error.message);
    });
  }

  cancel(i: any){
    this.complaints[i].response = this.prevResponse;
    this.showAddResponse = false;
  }

}
