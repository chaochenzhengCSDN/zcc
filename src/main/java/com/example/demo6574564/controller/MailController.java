package com.example.demo6574564.controller;

import com.example.demo6574564.service.IMailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

/**
 * @author Administrator
 * @date 2019-10-09 16:19
 */
@RestController
@RequestMapping("/Mail")
@Api(tags = "1.0", description = "邮件发送", value = "邮件发送")
public class MailController {

    private static final String SUCC_MAIL = "邮件发送成功！";
    private static final String FAIL_MAIL = "邮件发送失败！";

    // 图片路径
    private static final String IMG_PATH = "D://课程/兴趣/水印制作/美丽星空  2.jpg";
    // 发送对象
    private static final String MAIL_TO = "1325520624@qq.com";

    @Autowired
    private IMailService mailService;
    @Autowired
    private TemplateEngine templateEngine;

    /**
     * @Api：描述Controller
     * @ApiIgnore：忽略该Controller，指不对当前类做扫描
     * @ApiOperation：描述Controller类中的method接口
     * @ApiParam：单个参数描述，与@ApiImplicitParam不同的是，他是写在参数左侧的。如（@ApiParam(name = "username",value = "用户名") String username）
     * @ApiModel：描述POJO对象
     * @ApiProperty：描述POJO对象中的属性值
     * @ApiImplicitParam：描述单个入参信息
     * @ApiImplicitParams：描述多个入参信息
     * @ApiResponse：描述单个出参信息
     * @ApiResponses：描述多个出参信息
     * @ApiError：接口错误所返回的信息
     * @return
     */
    @PostMapping("/Email")
    @ApiOperation(value = "普通邮件发送")
    public String index(){
        try {
            mailService.sendSimpleMail(MAIL_TO,"这是一封普通的邮件","这是一封普通的SpringBoot测试邮件");
        }catch (Exception ex){
            ex.printStackTrace();
            return FAIL_MAIL;
        }
        return SUCC_MAIL;
    }

    @PostMapping("/htmlEmail")
    @ApiOperation(value = "HTML邮件发送")
    public String htmlEmail(){
        try {
            mailService.sendHtmlMail(MAIL_TO,"这是一HTML的邮件","<body>\n" +
                    "<div id=\"welcome\">\n" +
                    "    <h3>Welcome To My Friend!</h3>\n" +
                    "\n" +
                    "    GitHub：\n" +
                    "        <a href=\"#\" th:href=\"@{${github_url}}\" target=\"_bank\">\n" +
                    "            <strong>GitHub</strong>\n" +
                    "        </a>\n" +
                    "    <br />\n" +
                    "    <br />\n" +
                    "    个人博客：\n" +
                    "        <a href=\"#\" th:href=\"@{${blog_url}}\" target=\"_bank\">\n" +
                    "            <strong>DoubleFJ の Blog</strong>\n" +
                    "        </a>\n" +
                    "    <br />\n" +
                    "    <br />\n" +
                    "    <img width=\"258px\" height=\"258px\"\n" +
                    "         src=\"https://raw.githubusercontent.com/Folgerjun/materials/master/blog/img/WC-GZH.jpg\">\n" +
                    "    <br />微信公众号（诗词鉴赏）\n" +
                    "</div>\n" +
                    "</body>");
        }catch (Exception ex){
            ex.printStackTrace();
            return FAIL_MAIL;
        }
        return SUCC_MAIL;
    }

    @PostMapping("/attachmentsMail")
    @ApiOperation(value = "带附件的邮件发送")
    public String attachmentsMail(){
        try {
            mailService.sendAttachmentsMail(MAIL_TO, "这是一封带附件的邮件", "邮件中有附件，请注意查收！", IMG_PATH);
        }catch (Exception ex){
            ex.printStackTrace();
            return FAIL_MAIL;
        }
        return SUCC_MAIL;
    }

    @PostMapping("/resourceMail")
    @ApiOperation(value = "带图片的邮件发送")
    public String resourceMail(){
        try {
            String rscId = "DoubleFJ";
            String content = "<html><body>这是有图片的邮件<br/><img src=\'cid:" + rscId + "\' ></body></html>";
            mailService.sendResourceMail(MAIL_TO, "这邮件中含有图片", content, IMG_PATH, rscId);

        }catch (Exception ex){
            ex.printStackTrace();
            return FAIL_MAIL;
        }
        return SUCC_MAIL;
    }

    @PostMapping("/templateMail")
    @ApiOperation(value = "模板的邮件发送")
    public String templateMail(){
        try {
            Context context = new Context();
            context.setVariable("github_url", "https://github.com/Folgerjun");
            context.setVariable("blog_url", "http://putop.top/");
            String emailContent = templateEngine.process("mailTemplate", context);

            mailService.sendHtmlMail(MAIL_TO, "这是模板邮件", emailContent);
        }catch (Exception ex){
            ex.printStackTrace();
            return FAIL_MAIL;
        }
        return SUCC_MAIL;
    }
}

