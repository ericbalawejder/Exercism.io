# Given a DNA strand, return its RNA complement (per RNA transcription).
class Complement
  COMPLEMENTS = { 'G' => 'C',
                  'C' => 'G',
                  'T' => 'A',
                  'A' => 'U' }.freeze

  def self.of_dna(strand)
    # COMPLEMENTS.fetch(nucleotide, "default_value for nil key")
    rna = strand.chars.map { |nucleotide| COMPLEMENTS.fetch(nucleotide, '*') }.join
    rna = '' if rna.include?('*')
    rna
  end
end

module BookKeeping
  # Where the version number matches the one in the test.
  VERSION = 4
end

# Does not handle invalid input
# class Complement
#   DNA_RNA_MAPPINGS = ['GCTA', 'CGAU']
#
#   def self.of_dna(strand)
#     strand.tr(*DNA_RNA_MAPPINGS)
#   end
#
#   def self.of_rna(strand)
#     strand.tr(*DNA_RNA_MAPPINGS.reverse)
#   end
# end
