export interface Examination{
    id: number,
    dermatologist: any,
    price: number,
    schedule: Schedule,
    patient: any,
    prescription: any,
}

export interface Schedule{
    startDate: any,
    startTime: any,
    endTime: any,
}