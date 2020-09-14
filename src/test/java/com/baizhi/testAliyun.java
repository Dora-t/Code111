package com.baizhi;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectRequest;
import org.junit.Test;

import java.io.File;

/**
 * @ClassNmae: testAliyun
 * @Author: yddm
 * @DateTime: 2020/8/27 12:51
 * @Description: TODO
 */

public class testAliyun {
    @Test
    public void test1() {
        // Endpoint�Ժ���Ϊ��������Region�밴ʵ�������д��
        String endpoint = "http://oss-cn-beijing.aliyuncs.com";
        // ���������˺�AccessKeyӵ������API�ķ���Ȩ�ޣ����պܸߡ�ǿ�ҽ�����������ʹ��RAM�˺Ž���API���ʻ��ճ���ά�����¼ https://ram.console.aliyun.com ����RAM�˺š�
        String accessKeyId = "LTAI4G5UMgiJX68FJdio9jnG";
        String accessKeySecret = "Lr2RmJvktEgy84j2tgmeBNwJHZX9Iz";
        String filename = "video/1.mp4";
        String local = "E:\\20200827130408.mp4";

        // ����OSSClientʵ����
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        // ����PutObjectRequest����
        PutObjectRequest putObjectRequest = new PutObjectRequest("yingx-sjt", filename, new File(local));

        // �����Ҫ�ϴ�ʱ���ô洢���������Ȩ�ޣ���ο�����ʾ�����롣
        // ObjectMetadata metadata = new ObjectMetadata();
        // metadata.setHeader(OSSHeaders.OSS_STORAGE_CLASS, StorageClass.Standard.toString());
        // metadata.setObjectAcl(CannedAccessControlList.Private);
        // putObjectRequest.setMetadata(metadata);

        // �ϴ��ļ���
        ossClient.putObject(putObjectRequest);

        // �ر�OSSClient��
        ossClient.shutdown();
    }
}
