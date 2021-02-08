export interface Examination{
    id: number,
    dermatologist: any,
    price: number,
    schedule: Schedule,
    patient: any,
    prescription: any,
}

export interface ExaminationDto{
    id: number,
    email: string,
    patientDto: any,
    patientEmail: any,
    schedule: ScheduleDto,
    prescription: Prescription,
    pharmacyName: string,
    price: number,
    patientCame: boolean
}

export interface Schedule{
    startDate: any,
    startTime: any,
    endTime: any,
}

export interface ScheduleDto{
    id:any
}

export interface Prescription{
    days: any,
    diagnosis: any[],
    medicines: any[]
}

