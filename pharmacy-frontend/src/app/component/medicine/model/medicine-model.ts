import { Form } from '@angular/forms';
import { Observable } from 'rxjs';

export interface Medicine{
    id: number;
    code: number;
    name: string;
    typeOfMedicine: string;
    formOfMedicine: FormOfMedicine;
    composition: string;
    manufactured: string;
    publishingType: MedicinePublishingType;
    replacementMedicines: Observable<number>;
    note: string;
}

export interface MedicineDto{
    code: number;
    name: string;
    typeOfMedicine: string;
    formOfMedicine: FormOfMedicine;
    composition: string;
    manufactured: string;
    publishingType: MedicinePublishingType;
    replacementMedicines: Observable<number>;
    note: string;
}

export interface MedicinePharmacyDto{
    code: number;
    name: string;
    typeOfMedicine: string;
    formOfMedicine: FormOfMedicine;
    composition: string;
    manufactured: string;
    publishingType: MedicinePublishingType;
    alternative: Observable<number>;
    pharmacyName: string;
    price: number;
    amount: number;
    note: string;
}

enum FormOfMedicine {
    POWDER,
    CAPSULE,
    TABLET,
    GREASE,
    GEL,
    PASTE,
    DILUTION,
    SYRUP,
}

enum MedicinePublishingType {
    WITH_PRESCRIPTION,
    WITHOUT_PRESCRIPTION,
}
