import { Component, OnInit } from '@angular/core';
import { PharmacistService } from 'src/app/service/pharmacist.service';

@Component({
  selector: 'app-all-patients',
  templateUrl: './all-patients.component.html',
  styleUrls: ['./all-patients.component.css']
})
export class AllPatientsComponent implements OnInit {

  constructor(private pharmacistService: PharmacistService) { }

  ngOnInit(): void {
  }

}
