import { Observable } from 'rxjs';

export interface Medicine{
    code: number;
    name: string;
    type: string;
    form: string;
    manufactured: string;
    publishingType: string;
    amount: number;
    note: string;
}

export interface MedicineDto{
    code: number;
    name: string;
    typeOfMedicine: string;
    formOfMedicine: string;
    composition: Observable<string>;
    manufactured: string;
    publishingType: string;
    alternative: Observable<string>;
    pharmacyName: string;
    price: number;
    amount: number;
    note: string;
}
