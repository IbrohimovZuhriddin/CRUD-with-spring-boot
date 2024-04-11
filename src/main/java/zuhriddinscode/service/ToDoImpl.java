package zuhriddinscode.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import zuhriddinscode.dto.IconDTO;
//import zuhriddinscode.email.EmailSender;
import zuhriddinscode.entity.ToDoEntity;
import zuhriddinscode.repository.IconRepository;
import java.util.ArrayList;
import java.util.List;

@Service
public class ToDoImpl implements ToDoService {

//    private  final EmailSender emailSender;
//
//    public ToDoImpl(EmailSender emailSender) {
//        this.emailSender = emailSender;
//    }

    @Autowired
    private IconRepository iconRepository;

//    @Override
//    public String NewUpdate(Long id, IconDTO iconDTO) {
//        iconRepository.save(iconDTO);
//        return
//    }
    @Override
    public void update(Long id, IconDTO iconDTO) {  //
        ToDoEntity toDoEntity = null;
        try {
            toDoEntity = iconRepository.findById(id)
                    .orElseThrow(()-> new ChangeSetPersister.NotFoundException() );
        } catch (ChangeSetPersister.NotFoundException e) {
            throw new RuntimeException(e);
        }
        toDoEntity.setText(iconDTO.getText());
        toDoEntity.setDone(iconDTO.isDone());
        // Set other fields as needed

        iconRepository.save(toDoEntity);
//        return convertToDTO(savedToDo);
    }
//    private IconDTO convertToDTO(ToDoEntity toDoEntity) {
//        IconDTO dto = new IconDTO();
//        dto.setText(toDoEntity.getText());
//        dto.setDone(toDoEntity.isDone());
//        // Set other fields as needed
//        return dto;
//    }



    @Override
    public String addText(IconDTO iconDTO) {
//        int b = 0;
//      while (  b < 100  )
      {
        ToDoEntity toDoEntity = new ToDoEntity();
        toDoEntity.setText(iconDTO.getText());
         iconRepository.save(toDoEntity);
//      emailSender.send("ibrohimovzuhriddin310@gmail.com",buildEmail("Zuhriddin"));
//        b++;
      }

        return "IconDTO successfully saved";
    }

//    private String buildEmail(String name) {
//        return "<div style=\"font-family:Helvetica,Arial,sans-serif;font-size:16px;margin:0;color:#0b0c0c\">\n" +
//                "\n" +
//                "<span style=\"display:none;font-size:1px;color:#fff;max-height:0\"></span>\n" +
//                "\n" +
//                "  <table role=\"presentation\" width=\"100%\" style=\"border-collapse:collapse;min-width:100%;width:100%!important\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
//                "    <tbody><tr>\n" +
//                "      <td width=\"100%\" height=\"53\" bgcolor=\"#0b0c0c\">\n" +
//                "        \n" +
//                "        <table role=\"presentation\" width=\"100%\" style=\"border-collapse:collapse;max-width:580px\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" align=\"center\">\n" +
//                "          <tbody><tr>\n" +
//                "            <td width=\"70\" bgcolor=\"#0b0c0c\" valign=\"middle\">\n" +
//                "                <table role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse\">\n" +
//                "                  <tbody><tr>\n" +
//                "                    <td style=\"padding-left:10px\">\n" +
//                "                  \n" +
//                "                    </td>\n" +
//                "                    <td style=\"font-size:28px;line-height:1.315789474;Margin-top:4px;padding-left:10px\">\n" +
//                "                      <span style=\"font-family:Helvetica,Arial,sans-serif;font-weight:700;color:#ffffff;text-decoration:none;vertical-align:top;display:inline-block\">Confirm your email</span>\n" +
//                "                    </td>\n" +
//                "                  </tr>\n" +
//                "                </tbody></table>\n" +
//                "              </a>\n" +
//                "            </td>\n" +
//                "          </tr>\n" +
//                "        </tbody></table>\n" +
//                "        \n" +
//                "      </td>\n" +
//                "    </tr>\n" +
//                "  </tbody></table>\n" +
//                "  <table role=\"presentation\" class=\"m_-6186904992287805515content\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse;max-width:580px;width:100%!important\" width=\"100%\">\n" +
//                "    <tbody><tr>\n" +
//                "      <td width=\"10\" height=\"10\" valign=\"middle\"></td>\n" +
//                "      <td>\n" +
//                "        \n" +
//                "                <table role=\"presentation\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse\">\n" +
//                "                  <tbody><tr>\n" +
//                "                    <td bgcolor=\"#1D70B8\" width=\"100%\" height=\"10\"></td>\n" +
//                "                  </tr>\n" +
//                "                </tbody></table>\n" +
//                "        \n" +
//                "      </td>\n" +
//                "      <td width=\"10\" valign=\"middle\" height=\"10\"></td>\n" +
//                "    </tr>\n" +
//                "  </tbody></table>\n" +
//                "\n" +
//                "\n" +
//                "\n" +
//                "  <table role=\"presentation\" class=\"m_-6186904992287805515content\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse;max-width:580px;width:100%!important\" width=\"100%\">\n" +
//                "    <tbody><tr>\n" +
//                "      <td height=\"30\"><br></td>\n" +
//                "    </tr>\n" +
//                "    <tr>\n" +
//                "      <td width=\"10\" valign=\"middle\"><br></td>\n" +
//                "      <td style=\"font-family:Helvetica,Arial,sans-serif;font-size:19px;line-height:1.315789474;max-width:560px\">\n" +
//                "        \n" +
//                "            <p style=\"Margin:0 0 20px 0;font-size:19px;line-height:25px;color:#0b0c0c\">Hi " + name + ",</p><p style=\"Margin:0 0 20px 0;font-size:19px;line-height:25px;color:#0b0c0c\"> Thank you for registering. Please click on the below link to activate your account: </p><blockquote style=\"Margin:0 0 20px 0;border-left:10px solid #b1b4b6;padding:15px 0 0.1px 15px;font-size:19px;line-height:25px\"><p style=\"Margin:0 0 20px 0;font-size:19px;line-height:25px;color:#0b0c0c\"> <a href=\"" + "\">Activate Now</a> </p></blockquote>\n Link will expire in 15 minutes. <p>See you soon</p>" +
//                "        \n" +
//                "      </td>\n" +
//                "      <td width=\"10\" valign=\"middle\"><br></td>\n" +
//                "    </tr>\n" +
//                "    <tr>\n" +
//                "      <td height=\"30\"><br></td>\n" +
//                "    </tr>\n" +
//                "  </tbody></table><div class=\"yj6qo\"></div><div class=\"adL\">\n" +
//                "\n" +
//                "</div></div>";
//    }
    @Override
    public void deleteById(Long id) {
        iconRepository.deleteById(id);
    }

    @Override
    public List<IconDTO> findAll() {
    List<IconDTO> iconDTOList = new ArrayList<>();

    List<ToDoEntity> toDoEntities = iconRepository.findAll();// findall o'zi bor
    toDoEntities.forEach(toDoEntity -> {
        IconDTO iconDTO = new IconDTO();
        iconDTO.setDone(toDoEntity.isDone());
        iconDTO.setText(toDoEntity.getText());
        iconDTOList.add(iconDTO);
    });
    return iconDTOList;
    }

    @Override
    public List<IconDTO> findBYIsDoneAll(boolean isActive) {
        List<IconDTO> iconDTOList = new ArrayList<>();
        List<ToDoEntity> toDoEntities = iconRepository.findByDone(isActive);
        //findbydone ni o'zimiz yarataniz.

        toDoEntities.forEach(toDoEntity -> {
            IconDTO iconDTO = new IconDTO();
            iconDTO.setDone(toDoEntity.isDone());
            iconDTO.setText(toDoEntity.getText());
            iconDTOList.add(iconDTO);
        });
        return iconDTOList;
    }

    @Override
    public Page<IconDTO> getAllToDos(Pageable pageable) {
        Page<ToDoEntity> toDosPage = iconRepository.findAll(pageable);
        return  toDosPage.map(this::convertToDTO);
    }
    private IconDTO convertToDTO(ToDoEntity toDoEntity) {
            IconDTO dto = new IconDTO();
            dto.setDone(toDoEntity.isDone());
            dto.setText(toDoEntity.getText());
    return dto;
    }
}