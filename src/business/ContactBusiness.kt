package business

import entity.ContactEntity
import repository.ContactRepository
import java.lang.Exception

class ContactBusiness {


    private fun validate(name: String, phone: String){
        if(name.isNullOrEmpty()){
            throw Exception("Nome é obrigatório")
        }

        if(phone.isNullOrEmpty()){
            throw Exception("Telefone é Obrigatório")
        }
    }

    private fun validateDelete(name: String, phone: String){
        if(name.isNullOrEmpty() || phone.isNullOrEmpty()){
            throw Exception("É necessário selecionar um contato antes de remover")
        }
    }

    fun save(name: String, phone: String){
        validate(name, phone)

        val contact = ContactEntity(name, phone)
        ContactRepository.save(contact)
    }

    fun delete(name: String, phone: String){
        validateDelete(name, phone)

        val contact = ContactEntity(name, phone)
        ContactRepository.delete(contact)
    }

    fun getList(): MutableList<ContactEntity>{
        return ContactRepository.getList()
    }

    fun getContactCountDescription(): String{
        return ContactRepository.getList().count().toString() + " contatos"
    }

}