import { useState, useRef, React } from 'react'
import './SectionCadastro.css'
import api from '../../../api'

const Formulario = () => { 
    const nome= useRef()
    const email= useRef()
    const telefone= useRef()
    const data_nascimento= useRef()
    const cpf= useRef()

    const [Nome, setNome] = useState("")
    const [Email, setEmail] = useState("")
    const [Telefone, setTelefone] = useState("")
    const [Data_Nascimento, setdata_Nascimento] = useState("")
    const [CPF, setCpf] = useState("")
    
    
    
    function enviarDados(event){
        event.preventDefault()
        api.post("/users/adicionar",{
            nome: nome.current.value,
            email: email.current.value,
            telefone: telefone.current.value,
            data_nascimento: data_nascimento.current.value,
            cpf: cpf.current.value,
            
            
        }).then((res)=>console.log(res.data)).catch((err)=>console.log(err))
    }


    return (
        <section className="d-flex justify-content-center">
            <div className="card col-sm-6 p-3">
                <div className="mb-3">
                    <h4>Cadastro</h4>
                </div>
                <div className="mb-2"></div>
                <form action="" onSubmit={enviarDados}>
                    <div className="mb-2">
                        <label for="nome">Nome:</label>
                        <input type="text" required className="form-control bg-light btn-outline-secondary" ref={nome} placeholder="NOME" value={Nome} onChange={e => setNome(e.target.value)} /> </div>
                    
                        <div className="mb-2">
                            <label for="nome">E-mail:</label>
                            <input type="text" required className="form-control bg-light btn-outline-secondary" ref={email} placeholder="EMAIL" value={Email} onChange={e => setEmail(e.target.value)} />
                        </div>

                        
                        <div className="mb-2">
                            <label for="nome">Telefone:</label>
                            <input type="text" required className="form-control bg-light btn-outline-secondary" ref={telefone} placeholder="TELEFONE COM DDD*" value={Telefone} onChange={e => setTelefone(e.target.value)} />
                        </div>
                    
                    <div className="mb-2">
                        <label for="nome">Data de Nascimento:</label>
                        <input type="text" required className="form-control bg-light btn-outline-secondary" ref={data_nascimento}placeholder="20/01/1995" value={Data_Nascimento} onChange={e => setdata_Nascimento(e.target.value)} />
                    </div>

                    <div className="mb-2">
                        <label for="nome">Cpf</label>
                        <input type="text" required className="form-control bg-light btn-outline-secondary" ref={cpf}placeholder="123.456.789-87" value={CPF} onChange={e => setCpf(e.target.value)} />
                    </div>
                    
                    <div className="mb-2">

                        <br></br>
                        <button type="button" required className="btn btn-secondary btn-lg btn-block" onChange={e => alert(e.target.value)}>Cadastrar</button>
                    </div>
                </form>
            </div>
        </section >
    )
}
export default Formulario