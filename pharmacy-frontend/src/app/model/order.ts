import { Observable } from "rxjs";

export interface OrderDto{
    id: number;
    orderOffers: Observable<OrderOfferDto>;
    endDate: Date;
    endTime: Date;
    pharmacyAdminEmail: string;
}

export interface OrderOfferDto{
    medicineName: string;
    quantity: number;
    price: number;
}

export interface SupplierOfferDto{
    orderOffers: OrderOfferDto[];
    type: OrderOfferType;
    supplierEmail: string
}

export enum OrderOfferType{
    ACCEPTED = "ACCEPTED",
    REJECTED = "REJECTED",
    WAITING_FOR_ANSWER = "WAITING_FOR_ANSWER",
}
