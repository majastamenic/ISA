export const BACKEND_PATH = 'http://localhost:8081'

export const USER_PATH = BACKEND_PATH + '/user';
export const LOGIN_PATH = USER_PATH + '/login';

export const PHARMACY_PATH = BACKEND_PATH + '/pharmacy';
export const HOSPITAL_PATH = BACKEND_PATH + '/hospital';
export const ACTION_PATH = BACKEND_PATH + '/actions';

export const MEDICINE_PATH = BACKEND_PATH + '/medicine';
export const MEDICINEALL_PATH = BACKEND_PATH + '/medicine/getAllMedicines';
export const EPRESCRIPTION_PATH = BACKEND_PATH + '/ePrescription';
export const UPLOADQR_PATH = EPRESCRIPTION_PATH + '/uploadQr';

export const PATIENT_PATH = BACKEND_PATH + '/patient';
export const PATIENT_VALID_PATH = PATIENT_PATH + '/valid';