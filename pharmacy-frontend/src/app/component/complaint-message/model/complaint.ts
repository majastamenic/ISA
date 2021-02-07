export interface ComplaintDto{
    subject: string;
    complaintText: string;
    patientEmail: string;
}

export interface ShowComplaintDto{
    id: number;
    patientName: string;
    message: string;
    response: string;
}