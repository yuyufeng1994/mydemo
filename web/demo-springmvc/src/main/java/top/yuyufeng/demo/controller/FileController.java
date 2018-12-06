package top.yuyufeng.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.UUID;

/**
 * @author yuyufeng
 * @date 2018/12/6.
 */
@Controller
@RequestMapping("file")
public class FileController {
    /**
     * 打开上传页面
     *
     * @return
     */
    @RequestMapping(value = "upload", method = RequestMethod.GET)
    public String toUpload() {
        return "upload";
    }

    /**
     * 上传
     *
     * @param file1
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "doUpload", method = RequestMethod.POST)
    public String doUpload(@RequestParam(value = "file1") MultipartFile file1) throws IOException {
        file1.transferTo(new File("g://test/" + UUID.randomUUID().toString() + "-" + file1.getOriginalFilename()));
        return "upload";
    }

    /**
     * 下载
     *
     * @param response
     * @param fileName
     * @param ext
     * @throws Exception
     */
    @RequestMapping(value = "doDownload/{fileName}/{ext}", method = RequestMethod.GET)
    public void doDownload(HttpServletResponse response, @PathVariable("fileName") String fileName, @PathVariable("ext") String ext) throws Exception {
        try {
            InputStream inputStream = new FileInputStream("g://test/" + fileName + "." + ext);
            OutputStream os = response.getOutputStream();
            byte[] b = new byte[1024];
            int length;
            while ((length = inputStream.read(b)) > 0) {
                os.write(b, 0, length);
            }
            os.close();
            inputStream.close();
        } catch (FileNotFoundException e) {
            throw new Exception("文件不存在");
        } catch (IOException e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
        response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition", "attachment;fileName=" + fileName + "." + ext);
    }

    /**
     * 文件流
     *
     * @param response
     * @param fileName
     * @param ext
     * @return
     */
    @RequestMapping(value = "/stream/{fileName}/{ext}", method = RequestMethod.GET)
    public void stream(HttpServletResponse response, @PathVariable("fileName") String fileName, @PathVariable("ext") String ext) {
        try {
            InputStream inputStream = new FileInputStream("g://test/" + fileName + "." + ext);
            OutputStream os = response.getOutputStream();
            byte[] b = new byte[1024];
            int length;
            while ((length = inputStream.read(b)) > 0) {
                os.write(b, 0, length);
            }
            // 这里主要关闭。
            os.close();
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
