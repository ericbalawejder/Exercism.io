class Complement
  COMPLEMENTS = {'G' => 'C',
                 'C' => 'G',
                 'T' => 'A',
                 'A' => 'U'}.freeze
  # will not work
  #COMPLEMENTS.default = "*" 

  def self.of_dna(strand)
    # COMPLEMENTS.fetch(nucleotide, "default_value for nil key")
    rna = strand.chars.map {|nucleotide| COMPLEMENTS.fetch(nucleotide, "*")}.join
    # if it contains the default value, assign it to the empty string 
    if rna.include?("*")
      rna = ""
    end
    
    return rna
  end
end

module BookKeeping
  # Where the version number matches the one in the test.
  VERSION = 4
end