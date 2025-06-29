Feature: Endpoint POST/PET

  Scenario Outline: Validar cadastro de pet
    Given envio uma requisicao com <idPet> e <Name>
    Then aguardo json com PET cadastrado <idPet> e <Name>

    Examples: Campos para cadastro pet

   |idPet |   Name    |
   | 1050 |"Doguinho" |
   | 1051 |"Gatinho" |