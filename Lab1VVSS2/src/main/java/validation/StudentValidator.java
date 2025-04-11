package validation;

import domain.Student;

public class StudentValidator implements Validator<Student> {

    /**
     * Valideaza un student
     * @param entity - studentul pe care il valideaza
     * @throws ValidationException - daca studentul nu e valid
     */
    @Override
    public void validate(Student entity) throws ValidationException {
        if(entity.getID().equals("")){
            throw new ValidationException("Id incorect!");
        }
        if(entity.getID() == null){
            throw new NullPointerException("Id incorect!");
        }
        try {
            int id = Integer.parseInt(entity.getID());
            if (id < 0 || id > 9999) {
                throw new ValidationException("Id incorect!");
            }
        } catch (NumberFormatException e) {
            throw new ValidationException("Id incorect!");
        }
        if(entity.getNume() == ""){
            throw new ValidationException("Nume incorect!");
        }
        if(entity.getGrupa() < 0) {
            throw new ValidationException("Grupa incorecta!");
        }
        if(entity.getEmail() == null){
            throw new ValidationException("Email incorect!");
        }
        if(entity.getNume() == null){
            throw new ValidationException("Nume incorect!");
        }
        if(entity.getEmail().equals("")){
            throw new ValidationException("Email incorect!");
        }
        // Group validation
        int group = entity.getGrupa();
        boolean inValidGroupRange = (group >= 821 && group <= 822) || (group >= 921 && group <= 927);
        if (!inValidGroupRange) {
            throw new ValidationException("Grupa incorecta!");
        }
        if (!entity.getEmail().endsWith("@gmail.com") || entity.getEmail().startsWith("@gmail.com")) {
            throw new ValidationException("Email incorect!");
        }
    }
}
