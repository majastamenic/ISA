import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { ComplaintService } from 'src/app/service/complaint.service';

@Component({
  selector: 'app-complaint-message',
  templateUrl: './complaint-message.component.html',
  styleUrls: ['./complaint-message.component.css']
})
export class ComplaintMessageComponent implements OnInit {

  complaint: any = {patientEmail: '', points: 0};
  complaintText: string = '';
  subject: any;
  subjects: any;
  
  constructor(private complaintService: ComplaintService, private toastrService: ToastrService) { }

  ngOnInit(): void {
    let email = sessionStorage.getItem("user");
    if(email){
      this.complaintService.getSubjects(email).subscribe((response: any) => {
        this.subjects = response;
      });
    }
  }

  send(){
    this.complaintService.sendComplaint(this.complaint).subscribe((response: any)=>{
      this.toastrService.success("Sent complaint message.")
    },(err: any) => {
      this.toastrService.error("Error: " + err.error.message)
    });
  }

}
