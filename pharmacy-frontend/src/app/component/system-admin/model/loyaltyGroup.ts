export enum LoyaltyGroupType {
    EXAMINATION = 'EXAMINATION',
    COUNSELING = 'COUNSELING',
    REGULAR = 'REGULAR',
    SILVER = 'SILVER',
    GOLD = 'GOLD',
}

export interface LoyaltyGroup{
    type: LoyaltyGroupType;
    points: number;
}