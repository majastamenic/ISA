import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CounselingsService } from 'service/counselings.service';

@Component({
  selector: 'app-start-counseling',
  templateUrl: './start-counseling.component.html',
  styleUrls: ['./start-counseling.component.css']
})
export class StartCounselingComponent implements OnInit {

  id: any;
  counseling: any;


  constructor(private allCounseling: CounselingsService,
    private _ActivatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this._ActivatedRoute.paramMap.subscribe(params =>{
      this.id = params.get('id');
      this.allCounseling.startCounseling(this.id).subscribe(startCoun =>{
        this.counseling = startCoun;
        console.log(startCoun);
      })
    })
  }

}
