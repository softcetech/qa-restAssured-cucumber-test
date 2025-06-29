Feature: Endpoint PUT/PET

  Scenario Outline: Validar alteracao de pet
    Given envio uma requisicao para alterar pet com <idPet> e <Name>
    Then aguardo json com PET alterado <idPet> e <Name>

    Examples: Campos para cadastro pet

      |idPet |   Name    |
      | 1050 |"Doguinho novo nome" |
      | 1051 |"Gatinho novo nome" |