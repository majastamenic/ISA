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
    orderId: number;
    type: OrderOfferType;
    supplierEmail: string;
    totalPrice: number;
    deliveryDate: Date;
}

export enum OrderOfferType{
    ACCEPTED = "ACCEPTED",
    REJECTED = "REJECTED",
    WAITING_FOR_ANSWER = "WAITING_FOR_ANSWER",
}
