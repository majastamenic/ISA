export interface Counseling{
  id: any;
  user: any;
  patientDto: any;
  schedule: any;
  report: any;
  patientCame: any;
  counselingStatus: any;
}

export interface CounselingDto{
  id: any,
  email: any,
  patientDto: any,
  schedule: ScheduleDto,
  report: Report,
  patientCame: any,
  loyaltyGroup: any
}

export interface Report{
  days: any,
  medicines: any[]
}

export interface ScheduleDto{
  id:any
}
