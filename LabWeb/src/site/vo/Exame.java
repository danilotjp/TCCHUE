package site.vo;

public class Exame {
	private int id, id_paciente, id_tabelaExame, id_status;
	private String descricao;
	private Status status;
	private Examelab examelab;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getId_paciente() {
		return id_paciente;
	}
	public void setId_paciente(int id_paciente) {
		this.id_paciente = id_paciente;
	}
	public int getId_status() {
		return id_status;
	}
	public void setId_status(int id_status) {
		this.id_status = id_status;
	}
	public Examelab getExamelab() {
		return examelab;
	}
	public void setExamelab(Examelab examelab) {
		this.examelab = examelab;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public int getId_tabelaExame() {
		return id_tabelaExame;
	}
	public void setId_tabelaExame(int id_tabelaExame) {
		this.id_tabelaExame = id_tabelaExame;
	}	

}
