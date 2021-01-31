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
    verificationCode: string;
    active: boolean;
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
}
