import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { ComplaintService } from 'src/app/service/complaint.service';

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

  constructor(private complaintService: ComplaintService, private toastrService: ToastrService) { }

  ngOnInit(): void {
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
