export interface Patient{
    id: number;
    patient: User;
    verificationCode: string;
}

export interface User {
    id: number;
    email: string;
    password: string;
    name: string;
    surname: string;
    address: string;
    city: string;
    country: string;
    phone: string;
    active: boolean;
    role: Role;
}

export interface LoginUserDto {
    email: string;
    password: string;
}

export interface UserRegistrationDto{
    email: string;
    password: string;
    passwordAgain: string;
    name: string;
    surname: string;
    address: string;
    city: string;
    country: string;
    phone: string;
    role: Role;
}

export interface PasswordChangeDto{
    oldPassword: string;
    newPassword: string;
    newPasswordRepeat: string;
}

enum Role {
    PATIENT,
    ADMIN,
    DERMATOLOGIST,
    PHARMACIST,
    SUPPLIER,
    PHARMACY_ADMIN
}

export interface PharmacyAdminDto{
    email: string;
    password: string;
    passwordAgain: string;
    name: string;
    surname: string;
    address: string;
    city: string;
    country: string;
    phone: string;
    role: Role;
    pharmacyId: any; 
}
