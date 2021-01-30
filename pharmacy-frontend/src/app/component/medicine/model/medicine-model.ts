import { Observable } from 'rxjs';

export interface Medicine{
    id: number;
    code: number;
    name: string;
    typeOfMedicine: string;
    formOfMedicine: string;
    composition: Observable<string>;
    manufactured: string;
    publishingType: string;
    replacementMedicines: Observable<String>;
    note: string;
}

