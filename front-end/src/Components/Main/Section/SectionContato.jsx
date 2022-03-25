import { useState, useRef } from 'react'
import './SectionContato.css'
import api from '../../../api'



const FormularioContato = () => {
    const nome= useRef()
    const email= useRef()
    const mensagem= useRef()
    
    const [Nome, setNome] = useState("")
    const [Email, setEmail] = useState("")
    const [Mensagem, setMensagem] = useState("")

    function enviarDados(event){
        event.preventDefault()
        api.post("/suporte/novo",{
            nome: nome.current.value,
            email: email.current.value,
            mensagem: mensagem.current.value
            
        }).then((res)=>console.log(res.data)).catch((err)=>console.log(err))
    }




    return (
        <section className="d-flex justify-content-center">
            <div className="card col-sm-6 p-3">
                <div className="mb-3">
                    <h4>Contato</h4>
                </div>
                <div className="mb-2">
                    <form action="" onSubmit={enviarDados}>
                        <div className="mb-2">
                            <label for="nome">Nome:</label>
                            <input type="text" required className="form-control" ref={nome} nome="nome" id="nome" placeholder="Nome Completo" value={Nome} onChange={e => setNome(e.target.value)} />
                        </div>
                        <div className="mb-2">
                            <label for="email">E-mail:</label>
                            <input type="text" required className="form-control" ref={email}nome="email" id="email" placeholder="Ex: contato@gmail.com" value={Email} onChange={e => setEmail(e.target.value)} />
                        </div>
                        <div className="mb-2">
                            <label for="Mensagem">Mensagem:</label>
                            <textarea type="text" required className="form-control" ref={mensagem}nome="mensagem" id="mensagem" placeholder="Digite sua mensagem..." value={Mensagem} onChange={e => setMensagem(e.target.value)}></textarea>
                        </div>
                        <div className="mb-2">
                            <br></br>
                            <button className="btn btn-secondary btn-lg btn-block" onChange={e => alert(e.target.value)}>Enviar</button>
                        </div>
                    </form>
                </div>
            </div>
        </section>
    )
}
export default FormularioContato