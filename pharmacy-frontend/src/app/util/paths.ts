export const BACKEND_PATH = 'http://localhost:8081'

export const USER_PATH = BACKEND_PATH + '/user';
export const LOGIN_PATH = USER_PATH + '/login';
export const PASSWORD_USER_PATH = USER_PATH + '/password';
export const INFO_PATH = USER_PATH + '/info';
export const UPDATE_USER_PATH = USER_PATH + '/update';

export const PHARMACY_PATH = BACKEND_PATH + '/pharmacy';
export const HOSPITAL_PATH = BACKEND_PATH + '/hospital';
export const ACTION_PATH = BACKEND_PATH + '/actions';

export const MEDICINE_PATH = BACKEND_PATH + '/medicine';
export const MEDICINEALL_PATH = MEDICINE_PATH + '/getAllMedicines';
export const MEDICINES_CHECK_PATH = MEDICINE_PATH + '/check';

export const EPRESCRIPTION_PATH = BACKEND_PATH + '/ePrescription';
export const UPLOADQR_PATH = EPRESCRIPTION_PATH + '/uploadQr';
export const SCHEDULE_PATH = BACKEND_PATH + '/workschedule';
export const PHARMACIST_REGISTRATION_PATH = BACKEND_PATH + '/pharmacist/registration';
export const PHARMACISTSBYPHARMACY_PATH = BACKEND_PATH + '/pharmacist/pharmacists';

export const PATIENT_PATH = BACKEND_PATH + '/patient';
export const PATIENT_VALID_PATH = PATIENT_PATH + '/valid';
export const UPDATE_ALLERGY_PATH = PATIENT_PATH + '/updateAllergy';

export const DERMATOLOGIST_PATH = BACKEND_PATH + '/dermatologist';
export const PHARMACY_ADMIN_PATH = BACKEND_PATH + '/phadmin';
export const SUPPLIER_PATH = BACKEND_PATH + '/supplier';

export const SYSTEM_ADMIN_PATH = BACKEND_PATH + '/system_admin';

export const PRICELISTDEFINE_PATH = BACKEND_PATH + '/pricelist/define';

export const COUNSELING_PATH = BACKEND_PATH + '/counseling';
export const COUNSELING_ADD_PATH = COUNSELING_PATH + '/add';
export const COUNSELING_START_PATH = COUNSELING_PATH + '/start';

export const MEDICINEPHARMACY_PATH = BACKEND_PATH + '/medicinepharmacy';
export const GET_MEDICINEPHARMACY_PATH = BACKEND_PATH + '/getAllMedicines';
export const ORDER_INIT_PATH = BACKEND_PATH + '/order/define';
export const MEDICINES_PHARMACY_PATH = MEDICINEPHARMACY_PATH + '/all';


export const EXAMINATION_PATH = BACKEND_PATH + '/examination';
export const FREE_EXAM_TERMS_PATH = EXAMINATION_PATH + '/freeTerms';
export const SCHEDULE_EXAM_PATH = EXAMINATION_PATH + '/schedule';
export const EXAMINATION_START_PATH = EXAMINATION_PATH + '/start';

export const DIAGNOSIS_PATH = BACKEND_PATH + '/diagnosis';
export const DIAGNOSIS_ADD_PATH = DIAGNOSIS_PATH + '/add';

export const MEDICINE_LOYALTY_PATH = MEDICINE_PATH+'/loyalty';
export const LOYALTY_GROUP_PATH = BACKEND_PATH + '/loyaltyGroup';

export const COMPLAINT_PATH = BACKEND_PATH + '/complaint';
