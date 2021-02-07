import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { ComplaintService } from 'src/app/service/complaint.service';
import { ComplaintDto } from './model/complaint';

@Component({
  selector: 'app-complaint-message',
  templateUrl: './complaint-message.component.html',
  styleUrls: ['./complaint-message.component.css']
})
export class ComplaintMessageComponent implements OnInit {

  complaint: ComplaintDto = {subject: '', complaintText: '', patientEmail: ''};
  text: any;
  subject: any;
  subjects: any;
  
  constructor(private complaintService: ComplaintService, private toastrService: ToastrService) { }

  ngOnInit(): void {
    let email = sessionStorage.getItem("user");
    if(email){
      this.complaintService.getSubjects(email).subscribe((response: any) => {
        this.subjects = response;
      },
      (err: any) => {
        this.toastrService.error('Error ' + err.error.message);
      });
      this.complaint.patientEmail = email;
    }
  }

  send(){
    this.complaint.subject = this.subject;
    this.complaint.complaintText = this.text;
    this.complaintService.sendComplaint(this.complaint).subscribe((response: any)=>{
      this.toastrService.success("Sent complaint message.")
    },(err: any) => {
      this.toastrService.error("Error: " + err.error.message)
    });
  }

}