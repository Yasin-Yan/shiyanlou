package controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import entity.FileInfo;

@Controller
public class FileOperateController {

    // �ļ��ϴ�
    @RequestMapping(value="/upload")
    public String upload(HttpServletRequest request,@ModelAttribute FileInfo fileinfo,Model model) throws Exception{
        if(fileinfo.getFile().isEmpty()){
            return "failure";
        }else {
            // �ϴ�·��
            String path = request.getServletContext().getRealPath("/images/");
            // �ϴ��ļ���
            String filename = fileinfo.getFile().getOriginalFilename();
            File filepath = new File(path,filename);
            if(!filepath.getParentFile().exists())
                filepath.getParentFile().mkdirs();

            System.out.println("file path��"+path+File.separator+filename);
            // ���ļ����浽һ��Ŀ���ļ���
            fileinfo.getFile().transferTo(new File(path+File.separator+filename));
            // ���ϴ����ļ���Ϣ��ӽ� model
            model.addAttribute("fileinfo",fileinfo);
            // ��ת������ҳ��
            return "download";
        }

    }

    // �ļ�����
    @RequestMapping(value="/download")
    public ResponseEntity<byte[]> download(HttpServletRequest request,@RequestParam("filename") String filename) throws Exception{
        // ����·��
        String path = request.getServletContext().getRealPath("/images/");
        File file = new File(path+File.separator+filename);
        HttpHeaders headers = new HttpHeaders();
        // �����������
        String downloadfile =  new String(filename.getBytes("UTF-8"),"iso-8859-1");
        // �����ط�ʽ���ļ�
        headers.setContentDispositionFormData("attachment", downloadfile);
        // ��������
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers,HttpStatus.CREATED);

    }
}