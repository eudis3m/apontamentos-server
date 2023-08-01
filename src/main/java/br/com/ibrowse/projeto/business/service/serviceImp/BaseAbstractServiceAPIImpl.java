package br.com.ibrowse.projeto.business.service.serviceImp;

import java.lang.reflect.ParameterizedType;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import br.com.ibrowse.projeto.business.service.BaseServiceAPI;
import br.com.ibrowse.projeto.dto.ApontamentosTabelaDTO;
import br.com.ibrowse.projeto.entity.BaseEntity;
import br.com.ibrowse.projeto.exceptionhandlers.exceptions.EmptyElementException;
import br.com.ibrowse.projeto.exceptionhandlers.exceptions.NotFoundElementException;

@Service
public  abstract class BaseAbstractServiceAPIImpl<T extends BaseEntity> implements BaseServiceAPI<T>  {
	
	@Autowired
	private PagingAndSortingRepository<T, Long> repository;
	
	protected abstract T validateEntity(T obj) throws Exception;

	protected Boolean checkNullabilityOfTheEntityAndId(T obj) {
		return obj != null && obj.getOid() != null && obj.getOid().longValue() > 0L;
	}
	
	protected Boolean checkNullabilityOfId(Long oid) {
		return oid != null && oid.longValue() > 0L;
	}
	
//	@SuppressWarnings("unchecked")
//	protected T prepareAudit(T obj) throws Exception {
//		T old = null;
//		if(obj.getId() != null) {
//			old = findById((K) obj.getId());
//		}
//		if(old == null) {
//			obj.setDtCadastro(ZonedDateTime.now());
//			obj.setIdUsuarioCadastro(1L);
//		} else {
//			obj.setDtCadastro(old.getDtCadastro());
//			obj.setIdUsuarioCadastro(old.getIdUsuarioCadastro());
//		}
//		obj.setDtAlteracao(ZonedDateTime.now());
//		obj.setIdUsuariosAlteracao(1L);
//
///*		// Implementação para verificar e incrementar a versão do dado em auditoria
//		if(obj.getId() != null)
//			old = findById(obj.getId());
//		
//		if(old != null)
//			obj.setVsVersao(old.getVsVersao() + 1);
//		obj.setDtUltAlter(ZonedDateTime.now());
//		
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//	    String name = auth.getName(); //get logged in username
//		
//		obj.setDsUsuAlter(name);*/
//		
//		
//		return obj;
//	}
	
	@SuppressWarnings("unchecked")
	protected String getGenericName()
    {
        return ((Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0]).getSimpleName();
    }
	
	@Override
	public Page<T> findAllPage(Integer page, Integer linesPerPage, String orderBy, String direction, String nmusuario) {
		
		PageRequest pageRequest = PageRequest.of(page, linesPerPage,Direction.valueOf(direction), orderBy);
		return repository.findAll(pageRequest);
	}
	
	@Override
	public Page<T> findByExample(Integer page, Integer linesPerPage, String orderBy, String direction, String field, String  nmusuario) {
		
		PageRequest pageRequest = PageRequest.of(page, linesPerPage,Direction.valueOf(direction), orderBy);
		return repository.findAll(pageRequest);
	}
	
	@Override
	public T findById(Long oid) throws Exception {
		if(checkNullabilityOfId(oid)) {
			Optional<T> obj = repository.findById(oid);
			return obj.orElseThrow(() -> new NotFoundElementException(getGenericName() + " com identificador único = " + oid + " não encontrado! "));
		}
		//throw new NotFoundException(getGenericName() + " com identificador único = " + id + " não encontrado! ");
		throw new NotFoundElementException(getGenericName() + " com identificador único = " + oid + " não encontrado! ");
	}
	
	@Override
	public T create(T obj) throws Exception {
		if(obj != null) {
			obj.setOid(null);
//			obj = prepareAudit(obj);
			obj = validateEntity(obj);
			T resultSave = repository.save(obj);
			return resultSave;
		}
		throw new EmptyElementException(getGenericName() + " não pode ser inserido se vazio.");
	}

	@Override
	public T update(T obj) throws Exception {
		if(checkNullabilityOfTheEntityAndId(obj)) {
//			obj = prepareAudit(obj);
			T old = findById(obj.getOid());
		obj = validateEntity(obj);
			
			obj.setAuditoria(old);
			
			T address = repository.save(obj);
			return address;
		}
		throw new EmptyElementException(getGenericName() + " não pode ser atualizado se vazio.");
	}

	@Override
	public void delete(Long oid) throws Exception {
		T address = findById(oid);
		address.setIdAtivo("N");
		repository.delete(address);
		//repository.save(address);
	}


}
