package com.isa.pharmacy.service;

import com.isa.pharmacy.controller.dto.medicine.GetAllMedicinePharmacyDto;
import com.isa.pharmacy.controller.dto.medicine.MedicinePharmacyDto;
import com.isa.pharmacy.controller.mapping.MedicinePharmacyMapper;
import com.isa.pharmacy.domain.Counseling;
import com.isa.pharmacy.domain.Medicine;
import com.isa.pharmacy.domain.MedicinePharmacy;
import com.isa.pharmacy.repository.MedicinePharmacyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MedicinePharmacyService {
    @Autowired
    private MedicinePharmacyRepository medicinePharmacyRepository;
    @Autowired
    private CounselingService counselingService;

    public List<GetAllMedicinePharmacyDto> getAllMedicinePharmacies() {
        List<MedicinePharmacy> medicinePharmacies = medicinePharmacyRepository.findAll();
        List<GetAllMedicinePharmacyDto> medicineDtoList = new ArrayList<>();
        for(MedicinePharmacy medicine:medicinePharmacies){
                medicineDtoList.add(MedicinePharmacyMapper.mapMedicinePharmacyToGetAllMedicinePharmacyDto(medicine));
        }
        return medicineDtoList;
    }

    public List<GetAllMedicinePharmacyDto> getAllMedicinesByPharmacies(Long id) {
        List<MedicinePharmacy> medicinePharmacies = medicinePharmacyRepository.findMedicinePharmacyByPharmacy_id(id);
        List<GetAllMedicinePharmacyDto> medicineDtoList = new ArrayList<>();
        for(MedicinePharmacy medicine:medicinePharmacies){
            medicineDtoList.add(MedicinePharmacyMapper.mapMedicinePharmacyToGetAllMedicinePharmacyDto(medicine));
        }
        return medicineDtoList;
    }

    public List<String> getPatientAllergies(List<Medicine> allergis){
        List<String> meds = new ArrayList<>();
        for(Medicine m: allergis)
            meds.add(m.getName());
        return meds;
    }

    public List<MedicinePharmacyDto> getMedicinesByCounseling(long id){
        Counseling counseling = counselingService.getCounselingById(id);
        List<MedicinePharmacyDto> meds = new ArrayList<>();
        for(MedicinePharmacy mp : medicinePharmacyRepository.findMedicinePharmacyByPharmacy_id(counseling.getPharmacist().getPharmacy().getId())){
            for(String s : getPatientAllergies(counseling.getPatient().getAllergicMedicines())){
                if(mp.getMedicine().getName().equalsIgnoreCase(s)){
                    MedicinePharmacyDto mpd = MedicinePharmacyMapper.mapMedicinePharmacyToMedicinePharmacyDto(mp);
                    meds.add(mpd);
                }
            }
        }
        return meds;
    }

}
