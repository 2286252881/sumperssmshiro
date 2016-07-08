package zh.base.ws.soap_cxf;

import java.util.List;

import javax.jws.WebService;

import zh.base.pojo.po.Tpermission;

@WebService
public interface HelloService {
	List<Tpermission> say(String userName);
}
