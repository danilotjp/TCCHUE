package site.vo;

public class Paciente 
{
	private int id, cod_verif, endereco_num;
	private String nome_paciente, rg_paciente, cpf_paciente, datanasc_paciente, endereco_rua, endereco_bairro, cep, telefone_paciente, email_paciente, convenio_paciente;
	private Exame exame;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCod_verif(){
		return cod_verif;
	}
	public void setCod_verif(int cod_verif){
		this.cod_verif = cod_verif;
	}
	public int getEndereco_num(){
		return endereco_num;
	}
	public void setEndereco_num(int endereco_num){
		this.endereco_num = endereco_num;
	}
	public String getCep(){
		return cep;
	}
	public void setCep(String  cep){
		this.cep = cep;
	}
	public String getNome_paciente() {
		return nome_paciente;
	}
	public void setNome_paciente(String nome_paciente) {
		this.nome_paciente = nome_paciente;
	}
	public String getRg_paciente() {
		return rg_paciente;
	}
	public void setRg_paciente(String rg_paciente) {
		this.rg_paciente = rg_paciente;
	}
	public String getCpf_paciente(){
		return cpf_paciente;
	}
	public void setCpf_paciente(String cpf_paciente){
		this.cpf_paciente = cpf_paciente;
	}
	public String getEndereco_rua(){
		return endereco_rua;
	}
	public void setEndereco_rua(String endereco_rua){
		this.endereco_rua = endereco_rua;
	}
	public String getEndereco_bairro(){
		return endereco_bairro;
	}
	public void setEndereco_bairro(String endereco_bairro){
		this.endereco_bairro = endereco_bairro;
	}
	public String getTelefone_paciente(){
		return telefone_paciente;
	}
	public void setTelefone_paciente(String telefone_paciente){
		this.telefone_paciente = telefone_paciente;
	}
	public String getEmail_paciente(){
		return email_paciente;
	}
	public void setEmail_paciente(String email_paciente){
		this.email_paciente = email_paciente;
	}
	public String getDatanasc_paciente(){
		return datanasc_paciente;
	}
	public void setDatanasc_paciente(String datanasc_paciente){
		this.datanasc_paciente = datanasc_paciente;
	}
	public String getConvenio_paciente(){
		return convenio_paciente;
	}
	public void setConvenio_paciente(String convenio_paciente){
		this.convenio_paciente = convenio_paciente;
	}
	public Exame getExame() {
		return exame;
	}
	public void setExame(Exame exame) {
		this.exame = exame;
	}

	
	
}
